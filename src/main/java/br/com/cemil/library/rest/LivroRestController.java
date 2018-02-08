package br.com.cemil.library.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/livros",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class LivroRestController {
}
