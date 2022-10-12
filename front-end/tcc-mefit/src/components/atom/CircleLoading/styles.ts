import styled from 'styled-components';
import { pallet3, primaryColor, secondaryColor } from '../../../styles/themes';

export const StyPageCircleContainer = styled.div`
  width: 100%;
  height: 100%;
  align-items: center;
  display: flex;
  justify-content: center;
  z-index: 2000;
  position: relative;
  pointer-events: none;
`;

export const StySpinnerCircle = styled.div`
  width: 20px;
  height: 20px;
  position: relative;
`;

export const StySpinOne = styled.div`
  width: 20px;
  height: 20px;
  border: 5px solid transparent;
  border-left-color: ${secondaryColor};
  border-right-color: ${pallet3};
  border-radius: 50%;
  position: absolute;
  animation: spin 2s linear infinite;

  @keyframes spin {
    to {
      transform: rotate(360deg);
    }
  }
`;

export const StySpinTwo = styled.div`
  width: 20px;
  height: 20px;
  border: 5px solid transparent;
  border-top-color: ${secondaryColor};
  border-radius: 50%;
  position: absolute;
  animation: spin 4s linear infinite;

  @keyframes spin {
    to {
      transform: rotate(360deg);
    }
  }
`;
