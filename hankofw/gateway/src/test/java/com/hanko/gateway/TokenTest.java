package com.hanko.gateway;

import com.nimbusds.jose.JWSObject;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

/**
 * @Author: hanko
 * @Date: 2021-2-19 16:07
 */
public class TokenTest {
    @Test
    void test_token() throws Exception {
        String realToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJoYW5rbyIsInNjb3BlIjpbInNlcnZlciJdLCJleHAiOjE2MTM3NjY5MzQsImF1dGhvcml0aWVzIjpbIjYiLCI3Il0sImp0aSI6IjQ2NDhhYjViLTgxYzYtNDMyZS05MTY1LTIyNDFiMTY4NGUzNyIsImNsaWVudF9pZCI6ImFwcCIsInVzZXJuYW1lIjoiaGFua28ifQ.Eld2UTIR_LiYtTMFwTrQ0zGuv5qQ7FysjB7kYosgWEMjEaAwyiJXO7VcYTAgPgS0comQODTh5wKO-PFMH0HFJhJU6aM8OWscMszPmfEsW2g-dd-tU8VVOmQDbZwwxY7goMd-KHzWKxJeVdKjUyLn0gTKSbLTMEihkkwjgpCEu0sRA6aoVvqTDYOFhWGO0Qv66Qjk73bphM4-A0nPxgcizqmafa_cuS9Xr8KOiN5DiPUsgPVrDIr8m84F1HDN5QxkCUQT-GGsY9FmToux7cwTCNsWSSsclXYKFORpVNsJxel4uFYvmwBtjMDZZEu9ezyvjeP13428I5gUgNx_PmYxxA";
        JWSObject jwsObject = JWSObject.parse(realToken);
        String userStr = jwsObject.getPayload().toString();
        System.out.println(userStr);
    }
}
