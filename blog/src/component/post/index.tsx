import React from "react";
import Markdown from "react-markdown";

type Props = {
  title: string;
  body: string;
};

export default function Post({title, body}: Props) {

  return (
      <div>
        <h1>
          {title}
        </h1>
        <Markdown>
          {body}
        </Markdown>
      </div>
  )
}
