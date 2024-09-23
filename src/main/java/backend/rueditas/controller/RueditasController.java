package backend.rueditas.controller;

import backend.rueditas.dto.RequestPlacaDTO;
import backend.rueditas.dto.ResponsePlacaDTO;
import backend.rueditas.service.PlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/app")
public class RueditasController {

    @Autowired
    PlacaService placaService;

    @PostMapping("/buscar")
    public ResponsePlacaDTO buscarPlaca(@RequestBody RequestPlacaDTO request) {
        try {
            String[] response = placaService.buscarPlaca(request);
            if (response == null) {
                //ID -1 => no encontrado
                return new ResponsePlacaDTO(-1,  "", "", "", 0, 0, "");
            }
            return new ResponsePlacaDTO(
                    Integer.parseInt(response[0]),
                    response[1],
                    response[2],
                    response[3],
                    Integer.parseInt(response[4]),
                    Double.parseDouble(response[5]),
                    response[6]);

        } catch (IOException e) {
            //ID -99 => error interno
            return new ResponsePlacaDTO(-99,  "", "", "", 0, 0, "");
        }
    }
}
