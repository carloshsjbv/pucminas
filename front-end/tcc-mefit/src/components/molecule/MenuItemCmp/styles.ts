import styled from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

export const StyContainer = styled.div`
  width: 70px;
  height: 40px;

  & > button {
    // background: ${primaryColor};
    //color: ${secondaryColor};
    font-weight: 600;
  }
`;
