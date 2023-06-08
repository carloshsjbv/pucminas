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

const WorkoutPlanRegisterStep3Page: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);
  return (
    <MainTemplate>
      <StyContainer>
        <StyRowContainer>
          <StyTitle>Cadastro de Sessao de treinamento 3</StyTitle>
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Serie" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="Repetições" />
        </StyRowContainer>
        <StyButtonContainer>
          <StyButton onClick={() => changeRoute('workout-plan-register-step-2')}>
            CANCELAR
          </StyButton>
          <StyButton>SALVAR</StyButton>
        </StyButtonContainer>
      </StyContainer>
    </MainTemplate>
  );
};

export default WorkoutPlanRegisterStep3Page;
