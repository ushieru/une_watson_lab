package com.ushieru.une.watson.lab.controller;

import com.ushieru.une.watson.lab.dto.SetAsideHardwareRequest;
import com.ushieru.une.watson.lab.dto.SetAsideHardwareResponse;
import com.ushieru.une.watson.lab.model.Hardware;
import io.smallrye.common.constraint.NotNull;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Path("/hardware")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HardwareController {

    @GET
    public List<Hardware> list() {
        return Hardware.listAll();
    }

    @POST
    @Transactional
    public SetAsideHardwareResponse setAside(
            @NotNull SetAsideHardwareRequest request
    ) {
        Hardware hardware = Hardware.find("id", request.id).firstResult();
        if (hardware.quantity == 0) {
            throw new NotFoundException("Equipo no disponible");
        }
        // Codigo para generar folio de apartado.
        hardware.quantity -= 1;
        hardware.persist();
        var leftLimit = 97;
        var rightLimit = 122;
        var generatedString = new Random().ints(leftLimit, rightLimit + 1)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return new SetAsideHardwareResponse(generatedString);
    }
}
