import styled from 'styled-components';

export const StyContainer = styled.pre`
  background: rgb(40, 41, 54);
  text-shadow: none;
  font-family: Consolas, Monaco, 'Andale Mono', 'Ubuntu Mono', monospace;
  text-align: left;
  white-space: pre;
  word-spacing: normal;
  word-break: normal;
  word-wrap: normal;
  line-height: 1.8;
  font-size: 16px;
  -moz-tab-size: 4;
  -o-tab-size: 4;
  tab-size: 4;
  -webkit-hyphens: none;
  -moz-hyphens: none;
  -ms-hyphens: none;
  hyphens: none;
  border-radius: 10px;
  padding: 20px;
`;

export const StyCode = styled.code`
  display: flex;
  flex-direction: column;
  padding: 10px 15px;
  white-space: pre-wrap;
  font-size: 90%;
  margin: 0;
  padding: 2px 5px;
  border-radius: var(--border-radius-secondary);
  background-color: var(--color-bg-code);
  color: #e1e1e6;
`;

export const StyLineContainer = styled.code`
  display: flex;
  flex-direction: row;
`;

interface IStyWordFormatter {
  color: string;
}

export const StyWordFormatter = styled.span<IStyWordFormatter>`
  color: ${props => props.color};
`;
