package backend.rueditas.service.implemented;

import backend.rueditas.dto.RequestPlacaDTO;
import backend.rueditas.service.PlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PlacaServiceImp implements PlacaService {

    @Autowired
    ResourceLoader loader;

    @Override
    public String[] buscarPlaca(RequestPlacaDTO request) throws IOException {
        String[] auto = null;
        Resource resource = loader.getResource("classpath:autos.txt");
        try (BufferedReader br = new BufferedReader(
                             new FileReader(resource.getFile())))
        {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(";");
                if (data[1].equals(request.placa())) {
                    auto = new String[7];
                    auto[0] = data[0];
                    auto[1] = data[1];
                    auto[2] = data[2];
                    auto[3] = data[3];
                    auto[4] = data[4];
                    auto[5] = data[5];
                    auto[6] = data[6];
                }
            }
        } catch (IOException e) {
            auto = null;
            throw new IOException(e);
        }
        return auto;
    }
}
