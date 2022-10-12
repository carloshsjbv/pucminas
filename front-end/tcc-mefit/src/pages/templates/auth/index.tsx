import React from 'react';
import { StyContainer, StyContent, StyHeaderContainer } from './styles';

interface IAuthTemplate {
  backgroundImg?: string;
  header?: JSX.Element | undefined;
  footer?: JSX.Element | undefined;
}

const AuthTemplate: React.FC<IAuthTemplate> = ({ children }): JSX.Element => {
  return (
    <StyContainer>
      <StyHeaderContainer>
        <span>MeFit</span>
      </StyHeaderContainer>
      <StyContent>{children}</StyContent>
    </StyContainer>
  );
};

export default AuthTemplate;
