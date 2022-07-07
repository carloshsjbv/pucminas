import styled from "styled-components";
import {useState} from 'react';

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


const Text = () => { 

  const [message, setMessage] = useState('');
  const [asterisk, setAsterisk] = useState('*');

  const handleChange = event => {
    event.preventDefault();
    setMessage(event.target.value);

    if (message.length !== 0) {
      setAsterisk('');
      console.log('input value is NOT empty -' + asterisk);
    } else {
      setAsterisk('*')
      console.log('input value is empty -'+asterisk);
    }

  };

  return (
    <div>
    <InputText onChange={handleChange} />{asterisk} {message}
    </div>
  )
 
}

export default Text;