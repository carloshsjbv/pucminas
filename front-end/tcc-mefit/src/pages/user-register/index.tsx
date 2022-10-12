import React, { useContext } from 'react';
import { RouteContext } from '../../routes/route-manager';
import MainTemplate from '../templates/main';
import {
  StyInput,
  StyLoginButtonContainer,
  StyContainer,
  StyLoginInputsContainer,
  StyRowContainer,
  StyTitle,
  StyButton,
  StyButtonContainer,
} from './styles';

const UserRegisterPage: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);
  return (
    <MainTemplate>
      <StyContainer>
        <StyRowContainer>
          <StyTitle>Cadastro de Usuários</StyTitle>
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Nome" />
          <StyInput type="text" placeholder="Sobrenome" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="E-mail" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="CPF" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Profissão" />
        </StyRowContainer>
        <StyButtonContainer>
          <StyButton onClick={() => changeRoute('dashboard')}>
            CANCELAR
          </StyButton>
          <StyButton>SALVAR</StyButton>
        </StyButtonContainer>
      </StyContainer>
    </MainTemplate>
  );
};

export default UserRegisterPage;
