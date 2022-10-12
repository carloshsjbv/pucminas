import styled from 'styled-components';
import { pallet3, primaryColor } from '../../../styles/themes';

export const StyContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
  background: ${primaryColor};
`;

export const StyModule = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: left;
  align-items: center;
`;

export const StyImageContainer = styled.div`
  img {
    width: 50px;
    height: 50px;
  }
  margin: 0px 15px 0px 15px;
`;
