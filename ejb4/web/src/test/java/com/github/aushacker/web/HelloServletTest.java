package com.github.aushacker.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloServletTest extends AbstractHttpServletTest {

    private HelloServlet servlet;

    @BeforeEach
    public void setUp() throws IOException {
        super.setUp();
        servlet = new HelloServlet();
    }

    @Test
    public void testDoGet() throws IOException {
        servlet.doGet(request, response);

        verify(response).setStatus(HttpServletResponse.SC_OK);
        verify(response).setContentType("text/plain");
        assertEquals("Hello World!\n", getContent(), "content");
    }
}
