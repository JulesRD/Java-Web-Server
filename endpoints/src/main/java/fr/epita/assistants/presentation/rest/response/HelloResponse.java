package fr.epita.assistants.presentation.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@NoArgsConstructor
@Getter
public class HelloResponse {

    public String content;
    public HelloResponse(String name) {
        this.content = "hello " + name;
    }
}
