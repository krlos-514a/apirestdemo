package sv.edu.ues.dam235.apirestdemo.services;

import sv.edu.ues.dam235.apirestdemo.dtos.TokenDTO;

public interface AuthServices {
    public TokenDTO login(String user, String pass);
}