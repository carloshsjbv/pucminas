import styled from 'styled-components';
import { primaryColor, secondaryColor } from '../../../styles/themes';

export const StyContainer = styled.div``;

export const StyTitle = styled.div`
  h1 {
    color: ${primaryColor};
    font-weight: 600;
  }
  border-bottom: 2px solid ${primaryColor};
  border-end-start-radius: initial;
  margin-bottom: 30px;
`;

export const StyDescription = styled.div`
  margin-bottom: 30px;
`;

export const StySubtitle = styled.div`
  h4 {
    // font-weight: 600;
    margin-bottom: 10px;
  }
`;

export const StySubtitleContainer = styled.div`
  border: 1px solid ${primaryColor};
  margin-bottom: 30px;
  border-radius: 10px;
  padding: 10px;
  box-shadow: -5px 0 0 ${secondaryColor};
  border-left: transparent;
`;

export const StyCodeContainer = styled.div`
  h4 {
    //font-weight: 600;
    margin-bottom: 10px;
  }
  border: 1px solid ${primaryColor};
  margin-bottom: 30px;
  border-radius: 10px;
  padding: 10px;
  box-shadow: -5px 0 0 ${secondaryColor};
  border-left: transparent;
`;
