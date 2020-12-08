package com.cosmoplat.example.es.repository;

import com.cosmoplat.example.domain.AssetHealthEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AssetHealthRepository extends ElasticsearchRepository<AssetHealthEntity, Integer> {

}
