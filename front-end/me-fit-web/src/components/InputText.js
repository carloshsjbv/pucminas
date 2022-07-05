import styled from "styled-components";

const InputText = styled.input`
  font-size: 18px;
  padding: 10px;
  margin: 10px;
  background: white;
  border-left:none;
  border-right:none;
  border-top:none;
  border-bottom: 2px solid black;
  text-decoration-line: none;
  border-radius: 3px;
  &:focus {
    outline: none;
  }
  ::placeholder {
    color: black;
  }
`;

export default InputText;