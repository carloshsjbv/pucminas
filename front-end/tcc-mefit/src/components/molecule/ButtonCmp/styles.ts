import styled from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

interface IStyContainer {
  width: string;
}
export const StyContainer = styled.div<IStyContainer>`
  width: ${props => props.width};
  height: 40px;

  & > button {
    // background: ${primaryColor};
    //color: ${secondaryColor};
    font-weight: 600;
  }
`;
