import styled from 'styled-components';
const primaryColor: string = '#3A3042';
const secondaryColor: string = '#DB9D47';

export const StyContainer = styled.div`
  width: 50px;
  height: 100%;
  box-sizing: border-box;
  background: ${primaryColor};
  position: absolute;
  box-shadow: 5px 0 0 ${secondaryColor};
  overflow-x: hidden;
  transition: width 0.5s;
  z-index: 500;

  :hover {
    width: 200px;
  }

  & > ul {
    margin-top: 50px;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    padding-left: 5px;
    padding-top: 40px;
  }
`;

interface IStyItem {
  readonly isActive: boolean;
}

export const StyItem = styled.div<IStyItem>`
  width: 100%;
  height: 100%;
  position: relative;

  ::before {
    width: 30px;
    height: 30px;
    content: '';
    position: absolute;
    top: -30px;
    right: 0;
    z-index: 20;
    border-radius: 50%;
    box-shadow: ${props =>
      props.isActive
        ? `15px 15px 0 ${secondaryColor}`
        : '15px 15px 0 transparent'};
  }

  ::after {
    width: 30px;
    height: 30px;
    content: '';
    position: absolute;
    bottom: -30px;
    right: 0;
    z-index: 20;
    border-radius: 50%;
    box-shadow: ${props =>
      props.isActive
        ? `15px -15px 0 ${secondaryColor}`
        : '15px -15px 0 transparent'};
  }
`;

export const StyIcon = styled.div`
  display: block;
  width: 100%;
  height: 10%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #2f2735;

  svg {
    width: 50px;
    height: 50px;
    fill: ${secondaryColor};
  }
`;

export const StyMenuContainer = styled.div`
  background: blue;
  margin-top: 10px;
`;
