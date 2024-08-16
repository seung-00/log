import classNames from "classnames";
import React from "react";

type Props = {
  children: React.ReactNode
}

export default function Layout({children}: Props) {

  return (
      <div className={classNames("page_container")}>
        {children}
      </div>
  )
}
