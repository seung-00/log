import React from "react";

type Props = {
  children: React.ReactNode
}

export default function Fitting({children}: Props) {

  return (
      <div className="flex flex-col max-w-3xl mx-auto my-5">
        {children}
      </div>
  )
}
