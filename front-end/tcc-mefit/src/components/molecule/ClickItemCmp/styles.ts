import styled, { css, keyframes } from 'styled-components';
import {
  disableColor,
  primaryColor,
  secondaryColor,
} from '../../../styles/themes';

const animate = keyframes`
  from {
      width: 0px;
      height: 0px;
      opacity: 0.5;

  }

  to {
       width: 500px;
       height: 500px;
       opacity: 0;
  }
`;

interface IStyContainer {
  readonly disable: boolean;
}

export const StyContainer = styled.button<IStyContainer>`
  width: 100%;
  height: 100%;
  border: none;
  position: relative;
  //padding: 12px 36px;
  letter-spacing: 2px;
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  font-size: 12px;
  background: ${primaryColor};
  color: ${secondaryColor};
  padding: 5px;

  span {
    pointer-events: none;
  }

  .ripple {
    top: 20px !important;
    position: absolute;
    background: #fff;
    transform: translate(-50%, -50%);
    pointer-events: none;
    border-radius: 50%;
    animation: ${animate} 1s linear infinite;
  }

  ${props =>
    props.disable &&
    css`
      background: ${disableColor};
      cursor: not-allowed;
      color: #9d9d9d;
    `}
`;

interface IStyIconContainer {
  readonly disable: boolean;
}

export const StyIconContainer = styled.span<IStyIconContainer>`
  margin-right: 5px;
  margin-left: 5px;

  svg {
    width: 20px;
    height: 20px;
    fill: ${props => (props.disable ? '#9d9d9d' : secondaryColor)};
  }
`;
