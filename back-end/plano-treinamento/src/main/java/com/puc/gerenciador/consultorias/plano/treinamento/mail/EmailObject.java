package com.puc.gerenciador.consultorias.plano.treinamento.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.File;

@Builder
@AllArgsConstructor
public class EmailObject {

    public final String sendTo;

    public final String subject;

    public final String messageBody;

    public final boolean hasAttachment;

    public final File attachement;

}
