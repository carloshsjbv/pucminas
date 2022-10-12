import React, { ReactElement, useEffect, useState } from 'react';
import { CircleSpinner, Text } from '../../index';
import { StyContainer, StyIconContainer, StyUnderline } from './styles';

interface IInputTextCmp {
  id: string;
  //label: string;
  //onChange?: (...props: any) => void;
  // onClick?: (...props: any) => void;
  loading: boolean;
  // disable?: boolean;
  //icon?: ReactElement;
  onChange?: (compoentValue: string) => void;
}

const InputTextCmp: React.FC<IInputTextCmp> = ({
  id,
  //label,
  //onChange = () => null,
  //onClick = () => null,
  loading = false,
  //disable = false,
  //icon,
  onChange,
}) => {
  const [focus, setFocus] = useState<boolean>(false);
  function handleInputData(event: any) {
    if (event.target.value) {
      setFocus(true);
    } else {
      setFocus(false);
    }
    onChange && onChange(event.target.value);
  }
  return (
    <StyContainer
      id={id}
      onClick={() => null}
      onChange={() => null}
      disable={false}
      hasFocus={focus}
    >
      {loading ? (
        <CircleSpinner />
      ) : (
        <>
          <input
            id={id}
            type="text"
            autoComplete="off"
            onChange={handleInputData}
          />
          <StyUnderline />
          <label>
            <Text value="teste" />
          </label>
        </>
      )}
    </StyContainer>
  );
};

export default InputTextCmp;
