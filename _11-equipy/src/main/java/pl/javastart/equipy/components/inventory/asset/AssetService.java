package pl.javastart.equipy.components.inventory.asset;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    public AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }

    List<AssetDto> findAllByNameOrSerialNumber(String text) {
        return assetRepository.findAllByNameOrSerialNumber(text)
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }

    AssetDto save(AssetDto asset) {
        Optional<Asset> assetSerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetSerialNo.ifPresent(a -> {
            throw new DuplicateSerialNumberException();
        });
        return mapAndSaveAsset(asset);
    }

    AssetDto update(AssetDto asset) {
        Optional<Asset> assetSerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetSerialNo.ifPresent(a -> {
            if (!a.getId().equals(asset.getId())) {
                throw new DuplicateSerialNumberException();
            }
        });
        return mapAndSaveAsset(asset);
    }

    Optional<AssetDto> findById(Long id) {
        return assetRepository.findById(id).map(assetMapper::toDto);
    }

    private AssetDto mapAndSaveAsset(AssetDto asset) {
        Asset assetEntity = assetMapper.toEntity(asset);
        Asset savedAsset = assetRepository.save(assetEntity);
        return assetMapper.toDto(savedAsset);
    }

}

