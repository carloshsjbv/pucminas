import styled from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

export const StyContainer = styled.div`
  width: 120px;
  height: 40px;

  & > button {
    border-radius: 40px;
    // background: ${primaryColor};
    //color: ${secondaryColor};
    font-weight: 600;
  }
`;
