package fr.epita.assistants.presentation.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReverseRequest {

    public String content;
    public ReverseRequest(String content)
    {
        this.content = content;
    }
}
