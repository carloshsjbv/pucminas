import styled from 'styled-components';

export const StyLoginContainer = styled.div`
  background-color: #fff;
  width: 95%;
  height: 70%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

export const StyHeaderContainer = styled.div`
  width: 100%;
  border-bottom: 1px solid gray;
  font-size: 1em;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  color: gray;
`;

export const StyDashButton = styled.button`
  background-color: #fff;
  width: 45vw;
  height: 15vw;
  border: #1a6eed solid 0.1em;
  display: flex;
  justify-content: center;
  align-items: center;

  span {
    font-size: 1.5em;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    margin-right: 10px;
  }
`;

export const StyDashRow = styled.div`
  width: 100%;
  margin-top: 10px;
  margin-bottom: 10px;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  padding: 10px;
`;

export const StyLoginButtonContainer = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
`;
