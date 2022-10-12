import styled from 'styled-components';

export const StyContainer = styled.div`
  background-color: #fff;
  width: 50%;
  height: fit-content;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.7);
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-start;
  padding: 0px 50px;
`;

export const StyLoginInputsContainer = styled.div`
  width: 50%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin-bottom: 10px;
`;

export const StyLoginButtonContainer = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
`;

export const StyRowContainer = styled.div`
  width: 100%;
  padding: 20px;
  display: flex;
  justify-content: flex-start;
`;

export const StyInput = styled.input`
  width: 100%;
  height: 50px;
  border: none;
  border-bottom: 1px solid #000;
`;

export const StyTitle = styled.h3`
  margin: 10px;
  color: #000;
  cursor: pointer;
  font-weight: bolder;
`;

export const StyButton = styled.button`
  width: 40%;
  height: 50px;
  background: #1a6eed;
  color: #fff;
  border: none;
`;

export const StyButtonContainer = styled.div`
  width: 100%;
  padding: 20px;
  display: flex;
  justify-content: space-between;
  margin-top: 50px;
`;
