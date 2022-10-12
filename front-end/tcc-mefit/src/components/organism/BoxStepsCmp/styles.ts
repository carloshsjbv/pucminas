import styled, { keyframes } from 'styled-components';

export const StyContainer = styled.div`
  display: flex;
  flex-direction: row;
  max-width: 300px;
  overflow-x: hidden;
  scroll-behavior: smooth;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px,
    rgba(0, 0, 0, 0.22) 0px 10px 10px;
`;

export const StyStepBarContainer = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 5px;
  position: relative;
`;

export const StyStepBar = styled.div`
  width: 33%;
  height: 10px;
  background-color: rgba(190, 144, 212, 0.5);
`;

const fadeIn = keyframes`
  from {
      left: 0%;

  }

  to {
        left: 100%;
  }
`;

export const StyCurrentStepBar = styled.div`
  width: 33%;
  height: 10px;
  background-color: rgba(150, 54, 148, 1);
  position: absolute;
  animation: ${fadeIn} 1.2s ease-in-out;
  animation-iteration-count: initial;
`;
