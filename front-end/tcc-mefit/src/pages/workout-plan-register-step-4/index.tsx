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
  StyRowTableContainer,
  StyTable,
  StyTheader,
  StyTbody,
} from './styles';
import { StyTableHeader } from '../../components/organism/Table/styles';

const data = [
  { id: 1, serie: '3x10', exercicio: 'Supino reto' },
  { id: 2, serie: '3x10', exercicio: 'Supino inclinado' },
  { id: 3, serie: '3x10', exercicio: 'Rosca scott' },
  { id: 4, serie: '3x10', exercicio: 'Rosca direta' },
];

const WorkoutPlanRegisterStep4Page: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);
  return (
    <MainTemplate>
      <StyContainer>
        <StyRowContainer>
          <StyTitle>Cadastro de Sessao de treinamento 4 - Table</StyTitle>
        </StyRowContainer>
        <StyRowTableContainer>
          <StyTable>
            <StyTheader>
              <tr>
                <th>Serie</th>
                <th>Exercicio</th>
              </tr>
            </StyTheader>
            <StyTbody>
              {data.map((item) => (
                <tr key={item.id}>
                  <td>{item.serie}</td>
                  <td>{item.exercicio}</td>
                </tr>
              ))}
            </StyTbody>
          </StyTable>
        </StyRowTableContainer>
        <StyButtonContainer>
          <StyButton onClick={() => changeRoute('workout-plan-register-step-3')}>
            CANCELAR
          </StyButton>
          <StyButton>SALVAR</StyButton>
        </StyButtonContainer>
      </StyContainer>
    </MainTemplate>
  );
};

export default WorkoutPlanRegisterStep4Page;
