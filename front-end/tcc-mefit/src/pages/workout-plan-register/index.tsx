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

const WorkoutPlanRegisterPage: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);
  return (
    <MainTemplate>
      <StyContainer>
        <StyRowContainer>
          <StyTitle>Cadastro de Sessao de treinamento</StyTitle>
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Data final" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Data inicial" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Aluno" />
        </StyRowContainer>
        <StyButtonContainer>
          <StyButton onClick={() => changeRoute('dashboard')}>
            CANCELAR
          </StyButton>
          <StyButton onClick={() => changeRoute('workout-plan-register-step-2')}>
            SALVAR</StyButton>
        </StyButtonContainer>
      </StyContainer>
    </MainTemplate>
  );
};

export default WorkoutPlanRegisterPage;
