package com.tecnocampus.ecotaro.APPLICATION;

import com.tecnocampus.ecotaro.APPLICATION.DTO.ActivityDTO;
import com.tecnocampus.ecotaro.APPLICATION.DTO.CategoryDTO;
import com.tecnocampus.ecotaro.APPLICATION.DTO.ServiceDTO;
import com.tecnocampus.ecotaro.DOMAIN.Activity;
import com.tecnocampus.ecotaro.DOMAIN.Category;
import com.tecnocampus.ecotaro.DOMAIN.Services;
import com.tecnocampus.ecotaro.PERSISTANCE.CategoryRepository;
import com.tecnocampus.ecotaro.PERSISTANCE.ServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceManagementService {
    private final CategoryRepository categoryRepository;
    private final ServiceRepository serviceRepository;

    public ServiceManagementService(CategoryRepository categoryRepository, ServiceRepository serviceRepository) {
        this.categoryRepository = categoryRepository;
        this.serviceRepository = serviceRepository;
    }

    @Transactional
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository
                .findById(categoryDTO.getId())
                .orElseThrow(() -> new RuntimeException("This category already exists"));
        categoryRepository.save(category);
        return new CategoryDTO(category);
    }

    @Transactional
    public ServiceDTO createService(ServiceDTO serviceDTO) {
        Category category = categoryRepository.findById(serviceDTO.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Services services = new Services(serviceDTO);
        serviceRepository.save(services);
        return new ServiceDTO(services);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    public List<ServiceDTO> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(ServiceDTO::new)
                .collect(Collectors.toList());
    }

    public List<ServiceDTO> getServicesByCategory(String categoryId) {
        List<Services> services = ServiceRepository. findByCategoryId(categoryId);
        return services.stream().map(ServiceDTO::new).collect(Collectors.toList());
    }
}