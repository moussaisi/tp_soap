package sn.isi.diti5.web.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DITI5Endpoint {

    @PayloadRoot(namespace = "http://ws.groupeisi.com",localPart = "getInfoRequest")
    public @ResponsePayload GetInfoResponse getInfoRequest(@RequestPayload GetInfoRequest request){
        GetInfoResponse response = new GetInfoResponse();
        response.setOutput("Bonjour "+request.getInput());

        return response;
    }
}
