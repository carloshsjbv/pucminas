import styled from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

export const StyContainer = styled.div`
  width: 40px;
  height: 40px;
  position: relative;

  & > button {
    border-radius: 50%;
    // background: ${primaryColor};
    //color: ${secondaryColor};
    font-weight: 600;
  }
`;

export const StyIconContainer = styled.div`
  position: absolute;
  z-index: 10;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;
