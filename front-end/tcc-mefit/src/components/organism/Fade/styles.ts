import styled, { keyframes } from 'styled-components';

const fadeIn = keyframes`
  from {
      opacity:0;
      top: 30px;

  }

  to {
       opacity:1;
        top: 0px;
  }
`;

export const StyContainer = styled.div`
  animation: ${fadeIn} 0.5s ease-in-out;
  animation-iteration-count: 1;
  position: relative;
`;
