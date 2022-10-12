import React from 'react';
import { StyContainer, StyImageContainer, StyModule } from './styles';
import logo from '../../../assets/templates/images/app_logo/dns_codes.png';

const HeaderCmp: React.FC = () => {
  return (
    <StyContainer>
      <StyModule>
        <StyImageContainer>
          <img src={logo} alt="app_logo" />
        </StyImageContainer>
      </StyModule>
      <StyModule></StyModule>
    </StyContainer>
  );
};

export default HeaderCmp;
