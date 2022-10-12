import styled, { css } from 'styled-components';
import {
  primaryColor,
  primaryColorLess,
  secondaryColor,
} from '../../../styles/themes';

export const StyContainer = styled.div`
  font-size: 12px;
  width: 200px;
  height: fit-content;
  background-color: red;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`;
interface IStySubItemContainer {
  isOpen: boolean;
}
export const StySubItemContainer = styled.div<IStySubItemContainer>`
  width: 100%;
  //height: fit-content;
  display: flex;
  justify-content: center;
  align-items: center;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  overflow: hidden;
  transition: height 50s ease-in;
  height: ${({ isOpen }) => (isOpen ? 'fit-content' : 0)};
`;

interface IStyItem {
  isOpen: boolean;
}
export const StyItem = styled.div<IStyItem>`
  width: 100%;
  height: 40px;
  position: relative;

  & > button {
    background: ${primaryColor};
    //color: ${secondaryColor};
    font-weight: 600;
  }

  ${props =>
    props.isOpen &&
    css`
      ::after {
        content: '';
        position: absolute;
        width: 20px;
        height: 20px;
        background: ${primaryColor};
        left: 15px;
        bottom: -5px;
        z-index: 1;
        transform: rotate(45deg);
      }
    `}
`;

export const StySubItem = styled.div`
  width: 100%;
  height: 40px;

  & > button {
    background: ${primaryColorLess};
    // background: ${primaryColor};
    //color: ${secondaryColor};
    font-weight: 600;
  }
`;
