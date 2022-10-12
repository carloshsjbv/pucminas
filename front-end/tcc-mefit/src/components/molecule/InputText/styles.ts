import styled, { css, keyframes } from 'styled-components';
import {
  disableColor,
  primaryColor,
  secondaryColor,
} from '../../../styles/themes';

interface IStyContainer {
  readonly disable: boolean;
  readonly hasFocus: boolean;
}

export const StyContainer = styled.button<IStyContainer>`
  width: 200px;
  height: 40px;
  border: none;
  position: relative;
  //padding: 12px 36px;
  letter-spacing: 2px;
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  font-size: 12px;
  color: ${secondaryColor};
  background: transparent;

  input {
    width: 100%;
    height: 100%;
    padding-top: 5px;
    border: none;
    border-bottom: 2px solid silver;
    font-size: 12px;
    background: transparent;

    :focus {
      ~ label {
        transform: translateY(-20px);
        font-size: 12px;
      }

      ~ div:before {
        transform: scaleX(1);
      }
    }
  }

  label {
    position: absolute;
    bottom: 0px;
    pointer-events: none;
    font-size: 13px;
    width: 100%;
    height: 100%;
    transition: all 0.3s ease;
    font-weight: 600;
    transform: ${props => (props.hasFocus ? 'translateY(-20px)' : 'none')};

    ::after {
      content: '';
      position: absolute;
      height: 100%;
      width: 100%;
      // border-bottom: 3px solid #5fa8d3;
      //bottom: -1px;
    }

    & > span {
      position: absolute;
      bottom: 5px;
      left: 0px;
      transition: all 0.3s ease;
    }
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

export const StyUnderline = styled.div`
  position: absolute;
  bottom: 0px;
  height: 2px;
  width: 100%;

  ::before {
    content: 'teste';
    position: absolute;
    height: 100%;
    width: 100%;
    background: ${primaryColor};
    left: 0px;
    transition: 0.3s ease;
    transform: scaleX(0);
  }
`;
