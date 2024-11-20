package com.residenciasquad9.demo.domain.enums;

import java.util.Calendar;
import java.util.Date;

public enum TipoProtocolo {
    RECLAMAÇÃO(5),
    ELOGIO(10),
    INFORMAÇÃO(7),
    SOLICITAÇÃO(7),
    CONSULTA(7),
    DENUNCIA(3),
    CANCELAMENTO(2);

    private final int diasDePrazo;

    TipoProtocolo(int diasDePrazo) {
        this.diasDePrazo = diasDePrazo;
    }

    public int getDiasDePrazo() {
        return diasDePrazo;
    }

    // Método para calcular o prazo com base na data de abertura
    public Date calcularPrazo(Date dataAbertura) {
        if (dataAbertura == null) {
            throw new IllegalArgumentException("A data de abertura não pode ser nula.");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAbertura);
        calendar.add(Calendar.DAY_OF_MONTH, this.diasDePrazo);
        return calendar.getTime();
    }
}


