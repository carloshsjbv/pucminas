import React, { useContext } from 'react';
import MainTemplate from '../templates/main';
import {
  StyLoginContainer,
  StyDashButton,
  StyDashRow,
  StyHeaderContainer,
} from './styles';
import runningWorkout from '../../assets/templates/images/workout_running.jpeg';
import runningStudent from '../../assets/templates/images/workout_student1.jpeg';
import runningStudent2 from '../../assets/templates/images/workout_student2.jpeg';
import workoutObject from '../../assets/templates/images/workout_object.jpeg';
import workoutRunning2 from '../../assets/templates/images/workout_running2.jpeg';
import { RouteContext } from '../../routes/route-manager';

const DashboardPage: React.FC = (): JSX.Element => {
  const imageSize = '100px';
  const { changeRoute }: any = useContext(RouteContext);

  return (
    <MainTemplate>
      <StyLoginContainer>
        <StyHeaderContainer>Dashboard</StyHeaderContainer>
        <StyDashRow>
          <StyDashButton onClick={() => changeRoute('user-register')}>
            <span>Alunos</span>
            <img src={runningStudent} width={imageSize} height={imageSize} />
            <img src={runningStudent2} width={imageSize} height={imageSize} />
          </StyDashButton>
          <StyDashButton onClick={() => changeRoute('workout-register')}>
            <span>Treinos</span>
            <img src={runningWorkout} width={imageSize} height={imageSize} />
            <img src={workoutRunning2} width={imageSize} height={imageSize} />
          </StyDashButton>
        </StyDashRow>
        <StyDashRow>
          <StyDashButton onClick={() => changeRoute('workout-register')}>
            <span>Exercícios</span>
            <img src={workoutObject} width={imageSize} height={imageSize} />
          </StyDashButton>
        </StyDashRow>
      </StyLoginContainer>
    </MainTemplate>
  );
};

export default DashboardPage;
