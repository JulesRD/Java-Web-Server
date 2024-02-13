package fr.epita.assistants.presentation.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReverseResponse {
    public String reverse;
    public String original;
    public ReverseResponse(String original)
    {
        this.original = original;
        StringBuilder r = new StringBuilder();
        for (int i = 1; i <= original.length(); i++) {
            r.append(original.charAt(original.length() - i));
        }
        this.reverse = r.toString();
    }
}
