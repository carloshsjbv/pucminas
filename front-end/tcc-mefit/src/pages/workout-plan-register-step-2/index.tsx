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

const WorkoutPlanRegisterStep2Page: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);
  return (
    <MainTemplate>
      <StyContainer>
        <StyRowContainer>
          <StyTitle>Cadastro de Sessao de treinamento 2</StyTitle>
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Serie" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Repetições" />
        </StyRowContainer>
        <StyButtonContainer>
          <StyButton onClick={() => changeRoute('workout-plan-register')}>
            CANCELAR
          </StyButton>
          <StyButton onClick={() => changeRoute('workout-plan-register-step-3')} >
            SALVAR</StyButton>
        </StyButtonContainer>
      </StyContainer>
    </MainTemplate>
  );
};

export default WorkoutPlanRegisterStep2Page;
