import styled from 'styled-components';

export const StyContainer = styled.div`
  width: 100%;
  height: 100%;
  background-color: #fff;
`;

export const StyHeaderContainer = styled.div`
  width: 100%;
  height: 10%;
  background: #1a6eed;
  display: flex;
  align-items: center;

  span {
    font-weight: bolder;
    font-family: Arial, Helvetica, sans-serif;
    margin-left: 10px;
    font-size: 1.5em;
    color: #fff;
  }
`;

export const StyContent = styled.div`
  width: 100%;
  height: 90%;
  display: flex;
  justify-content: center;
  align-items: center;
`;
