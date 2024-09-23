package backend.rueditas.service;

import backend.rueditas.dto.RequestPlacaDTO;

import java.io.IOException;

public interface PlacaService {
    String[] buscarPlaca(RequestPlacaDTO request) throws IOException;
}
