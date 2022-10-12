import React, { useContext } from 'react';
import { RouteContext } from '../../routes/route-manager';
import AuthTemplate from '../templates/auth';
import {
  StyButton,
  StyInput,
  StyLoginContainer,
  StyRowContainer,
  StyText,
} from './styles';

const LoginPage: React.FC = (): JSX.Element => {
  const { changeRoute }: any = useContext(RouteContext);

  return (
    <AuthTemplate>
      <StyLoginContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="email" />
        </StyRowContainer>
        <StyRowContainer>
          <StyInput type="text" placeholder="senha" />
        </StyRowContainer>
        <StyRowContainer>
          <StyButton onClick={() => changeRoute('dashboard')}>LOGIN</StyButton>
        </StyRowContainer>

        <StyText>Esqueci minha senha</StyText>
        <StyText>Cadastre-se</StyText>
      </StyLoginContainer>
    </AuthTemplate>
  );
};

export default LoginPage;
