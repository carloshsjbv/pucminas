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

const WorkoutRegisterPage: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);
  return (
    <MainTemplate>
      <StyContainer>
        <StyRowContainer>
          <StyTitle>Cadastro de Exercícios</StyTitle>
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Nome" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Grupo Muscular" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Vídeo URL" />
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

export default WorkoutRegisterPage;
