import styled, { css } from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

interface IStyContainer {
  readonly isExpand: boolean;
}
export const StyContainer = styled.div<IStyContainer>`
  background: red;
  position: relative;
  width: 300px;
  height: 50px;

  input {
    position: absolute;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    cursor: pointer;
    background: #fff;
    border: none;
    box-shadow: 0 5px 20px rgba(0, 0, 0, 0.05);
    outline: none;
    padding: 12px 20px;
    // border-radius: 10px;
  }

  ::before {
    content: '';
    position: absolute;
    right: 20px;
    top: 15px;
    z-index: 1000;
    width: 8px;
    height: 8px;
    border: 2px solid ${primaryColor};
    border-top: none;
    border-right: none;
    transform: rotate(-45deg);
    transition: 0.5s;
    pointer-events: none;
    border-radius: 20%;
    pointer-events: none;

    ${props =>
      !props.isExpand &&
      css`
        top: 22px;
        transform: rotate(-225deg);
      `}
  }
`;

interface IStyOptionsContainer {
  readonly isExpand: boolean;
}

export const StyOptionsContainer = styled.div<IStyOptionsContainer>`
  width: 100%;
  position: absolute;
  top: 40px;
  background: #fff;
  box-shadow: 0 30px 30px rgba(0, 0, 0, 0.05);
  // border-radius: 10px;
  display: block;

  ${props =>
    !props.isExpand &&
    css`
      display: none;
    `}
`;

export const StyIconContainer = styled.div``;

export const StySelectBox = styled.div`
  width: fit-content;
  height: fit-content;
`;

export const StyOption = styled.div`
  padding: 12px 20px;
  cursor: pointer;
  position: relative;

  :hover {
    background: ${primaryColor};
    color: ${secondaryColor};
  }
`;
