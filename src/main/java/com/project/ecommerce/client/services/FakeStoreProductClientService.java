package com.project.ecommerce.client.services;

import com.project.ecommerce.client.DTOs.FakeStoreRequestDTO;
import com.project.ecommerce.client.DTOs.FakeStoreResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class FakeStoreProductClientService implements ThirdPartyClientProductService {

    @Value("${productbaseurl}")
    private String baseUrl;
    private RestTemplate restTemplate;
    public FakeStoreProductClientService(RestTemplate restTemplate,
                                         @Value("${productbaseurl}") String baseUrl) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<FakeStoreResponseDTO> getAllProductsFromClient() {
        ParameterizedTypeReference<List<FakeStoreResponseDTO>> responseType = new ParameterizedTypeReference<List<FakeStoreResponseDTO>>() {};
        ResponseEntity<List<FakeStoreResponseDTO>> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, null, responseType);
        List<FakeStoreResponseDTO> productList = responseEntity.getBody();
        return productList;
    }

    @Override
    public FakeStoreResponseDTO getProductFromClient(Long id) {
        String apiUrl = baseUrl.concat("/{id}");
        return restTemplate.getForObject(apiUrl, FakeStoreResponseDTO.class, id);
    }

    @Override
    public FakeStoreResponseDTO addNewProductToClient(FakeStoreRequestDTO fakeStoreRequestDTO) {
        RequestEntity<FakeStoreRequestDTO> requestEntity = RequestEntity
                .post(baseUrl)
                .body(fakeStoreRequestDTO);

        ResponseEntity<FakeStoreResponseDTO> responseEntity = restTemplate.exchange(
                requestEntity,
                FakeStoreResponseDTO.class);

        return responseEntity.getBody();
    }

    @Override
    public FakeStoreResponseDTO updateProductInClient(FakeStoreRequestDTO fakeStoreRequestDTO, Long id) {
        String apiUrl = baseUrl.concat("/{id}");
        URI uri = UriComponentsBuilder.fromUriString(apiUrl).buildAndExpand(id).toUri();
        RequestEntity<FakeStoreRequestDTO> requestEntity = RequestEntity
                .patch(baseUrl)
                .body(fakeStoreRequestDTO);

        ResponseEntity<FakeStoreResponseDTO> responseEntity = restTemplate.exchange(
                requestEntity,
                FakeStoreResponseDTO.class);

        return responseEntity.getBody();
    }

    @Override
    public FakeStoreResponseDTO replaceProductInClient(FakeStoreRequestDTO fakeStoreRequestDTO, Long id) {
        String apiUrl = baseUrl.concat("/{id}");
        URI uri = UriComponentsBuilder.fromUriString(apiUrl).buildAndExpand(id).toUri();
        RequestEntity<FakeStoreRequestDTO> requestEntity = RequestEntity
                .put(uri)
                .body(fakeStoreRequestDTO);

        ResponseEntity<FakeStoreResponseDTO> responseEntity = restTemplate.exchange(
                requestEntity,
                FakeStoreResponseDTO.class);

        return responseEntity.getBody();
    }

    @Override
    public FakeStoreResponseDTO deleteProductFromClient(Long id) {
        String apiUrl = baseUrl.concat("/{id}");
        URI uri = UriComponentsBuilder.fromUriString(apiUrl).buildAndExpand(id).toUri();
        RequestEntity<Void> requestEntity = RequestEntity.delete(apiUrl, id).build();

        ResponseEntity<FakeStoreResponseDTO> responseEntity = restTemplate.exchange(
                requestEntity,
                FakeStoreResponseDTO.class);

        return responseEntity.getBody();
    }
}
